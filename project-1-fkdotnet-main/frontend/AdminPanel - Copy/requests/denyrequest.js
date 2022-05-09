
let servURL = "http://localhost:9898/"
let DenyReimbursementTextBox = document.getElementById('reimbIDtoDeny')
const submit_deny_button = document.querySelector("#submitDenyBtn");
submit_deny_button.addEventListener("click",CreateRequestJSON)

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


function CreateRequestJSON(){
  let reimbursementID = DenyReimbursementTextBox.value;
  let user_id = readCookie("userid");
 
 
 
 
  let requestbodyObject = {
     "reimb_resolver": `${user_id}`,
    "reimb_id": `${reimbursementID}`
}
let denyRequestJSON = JSON.stringify(requestbodyObject);
return submitDenial(denyRequestJSON);
}





async function submitDenial(denyRequestJSON){
let response = await fetch(servURL + "denyrequest/", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: denyRequestJSON,
  });

}

  