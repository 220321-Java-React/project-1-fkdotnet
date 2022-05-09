// Constants here to include FETCH URLs, and numeric finals.
const ServerURL = "http://localhost:9898";
//all new, and thus pending requests have type 1 on my table, so can use as constant for all new requests

const NEW_REIMBURSEMENT_STATUS_ID = 1;
const LODGING_TRAVEL_STATUS_TYPE = 1;
const TRAVEL_REIMBURSEMENT_STATUS_TYPE = 2;
const FOOD_REIMBURSEMENT_STATUS_TYPE = 3;
const OTHER_REIMBURSEMENT_STATUS_TYPE = 4;
const submit_button = document.querySelector("#submit");
submit_button.addEventListener("click", reimbValidation);
let reimbursement_description_form = document.querySelector(
  "#reimbursementdescription"
);
function readCookie(name) {
  var nameEQ = name + "=";
  var ca = document.cookie.split(";");
  for (var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == " ") c = c.substring(1, c.length);
    if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
  }
  return null;
}

function reimbValidation() {
  //going to iterate through radio select here!

  var checkRadio = document.querySelector('input[name="reimbursementType"]:checked');
  let selected_type_id = 0;
  switch (checkRadio) {
    case "reimbursementtypelodging": {
      selected_type_id = LODGING_TRAVEL_STATUS_TYPE;
    }
    case "reimbursementtypefood": {
      selected_type_id = FOOD_REIMBURSEMENT_STATUS_TYPE;
    }
    case "reimbusementtypetravel": {
      selected_type_id = TRAVEL_REIMBURSEMENT_STATUS_TYPE;
    }
    case "reimbursementtypeother": {
      selected_type_id = OTHER_REIMBURSEMENT_STATUS_TYPE;
    }
  }

  return SubmitReimbPostRequest(
    selected_type_id,
    reimbursement_amount_form.value,
    reimbursement_description_form.value
  );
}

let reimbursement_amount_form = document.querySelector("#reimbursementamount");
let reimbursement_type_selection =
  document.getElementsByName("reimbursementType");
let reimbursement_reset_button = document.querySelector("#resetform");


function reimbValidation() {
  //going to iterate through radio select here!

  var checkRadio = document.querySelector('input[name="reimbursementType"]:checked').value;

  let selected_type_id;
  switch (checkRadio) {
    case"Lodging": {
      selected_type_id = LODGING_TRAVEL_STATUS_TYPE;
      break;
    }
    case "Food": {
      selected_type_id = FOOD_REIMBURSEMENT_STATUS_TYPE;
      break;
    }
    case "Travel": {
      selected_type_id = TRAVEL_REIMBURSEMENT_STATUS_TYPE;
      break;
    }
    case "Other": {
      selected_type_id = OTHER_REIMBURSEMENT_STATUS_TYPE;
      break;
    }
  }

  return SubmitReimbPostRequest(
    selected_type_id,
    reimbursement_amount_form.value,
    reimbursement_description_form.value
  );
}

//this is really all we have to grab from the SessionHandler for this, but i see no reason to write another handler, so we will use our generic login session!

async function SubmitReimbPostRequest(
  reimb_type_id,
  amount,
  reimb_description
) {
  let users_id = readCookie("userid");

  let reimbursemententity = {
    reimb_author: `${users_id}`,
    reimb_status_id: `${NEW_REIMBURSEMENT_STATUS_ID}`,
    reimb_type_id: `${reimb_type_id}`,
    reimb_amount: `${amount}`,
    reimb_description: `${reimb_description}`,
    reimb_resolver: 0
  };
  console.log("PRE json object" + reimbursemententity.toString());
  let JsonReimbursement = JSON.stringify(reimbursemententity);
  console.log(JsonReimbursement);
  let response = await fetch(
    ServerURL + "/submitreimbursement/",
    {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JsonReimbursement,
    },
    { credentials: "include" }
  );

  if (response.status == 202) {
    console.log(JsonReimbursement + " was sent to jetty!");
  }
}

// in the world of learning we should ALL use verbose names, says the guy who called his GSON builder BOB
