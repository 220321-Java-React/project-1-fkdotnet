const TableReqUrl = "http://localhost:9898"
document.addEventListener("DOMContentLoaded", function() {
    RenderTable();
  });
async function RenderTable(){
    let response = await fetch(TableReqUrl + "/getallreimb/",{credentials: "include"});
    if (response.status === 200){
        let data = await response.json()
        console.log(data);
       
        for(let reimb of data){
            
            
            

            let row = document.createElement("tr");
            let cell = document.createElement("td");

            cell.innerHTML = reimb.reimb_id;
            row.appendChild(cell);
            
            let cell2 = document.createElement("td");
            cell2.innerHTML = reimb.reimb_amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimb.reimb_type_id;
            row.appendChild(cell3);
            
            let cell4 = document.createElement("td");
            cell4.innerHTML = reimb.reimb_description;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = reimb.reimb_author
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimb.reimb_submitted;
            row.appendChild(cell6);

            let cell7 = document.createElement("td");
            cell7.innerHTML = reimb.reimb_resolved;
            row.appendChild(cell7);

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimb.reimb_resolver;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimb.reimb_status_id;
            row.appendChild(cell9);

            document.getElementById("sqltable").appendChild(row);

        }
    }

}
