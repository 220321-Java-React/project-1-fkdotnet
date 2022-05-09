let usernameInput = document.getElementsByName("username")[0];
let passwordInput = document.getElementsByName("password")[0];
// We also want to grab the button to give it additional functionality

let submitButton = document.querySelector("#submitButton");
// We add in an event for clicking the submit button
submitButton.addEventListener("click", loginValidation, true);


function loginValidation(){
    let username = usernameInput.value;
    let password = passwordInput.value;
    // I add in a console.log to make sure I am getting the inputs properly
    console.log(username);
    console.log(password);
    
    // Call the fetch login here
    fetchLogin(username, password);
}


async function fetchLogin(usernameInput, passwordInput){
    // This is the url of my javalin server and its endpoint that I want
    // to use
    const URL = "http://localhost:9898/adminlogin/";

    // We create an object representation of the user login
    // The fields (keys) must match our Java model (DTO)
    let UserLogin = {
        username: usernameInput,
        password: passwordInput
    };

    let jsonUser = JSON.stringify(UserLogin);
    console.log(jsonUser);

    // We send off a fetch request with an object representation
    // Of our HTTP request
    let response = await fetch(URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonUser
    });

    
    if(response.status == 202 ){
        let result = await response.json();
        alert("Login Successful! Redirecting to Admin Panel...")
        document.cookie =
        "userid=" +
        JSON.stringify(result.users_id) +
        ";path =/AdminPanel/AdminPanel.html";
      document.cookie =
        "first_name=" +
        JSON.stringify(result.firstname) +
        ";path =/AdminPanel/AdminPanel.html";
        window.location.href="/AdminPanel/adminpanel.html";
    }
    else{
        alert("Login Failed, please try again!");
    }

}