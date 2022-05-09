
let URL = "http://localhost:9898/"
let ApproveReimbursementTextBox = document.getElementById('reimbIDtoApprove')
const submit_app_button = document.querySelector("#approveBtn");
submit_app_button.addEventListener("click",CreateRequestJSON)

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
  let reimbursementID = ApproveReimbursementTextBox.value;
  let user_id = readCookie("userid");
 
 
 
 
  let requestbodyObject = {
     "reimb_resolver": `${user_id}`,
    "reimb_id": `${reimbursementID}`
}
let approveRequestJSON = JSON.stringify(requestbodyObject);
return submitApproval(approveRequestJSON);
}





async function submitApproval(approveRequestJSON){
let response = await fetch(URL + "approverequest/", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: approveRequestJSON,
  });

}

  