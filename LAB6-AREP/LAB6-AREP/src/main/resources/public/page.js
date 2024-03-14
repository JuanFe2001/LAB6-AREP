function loadGetMsg() {
    
    let msgVar = document.getElementById("msg").value;


    fetch("/logservicefacade?msg=" + encodeURIComponent(msgVar))
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al obtener los registros');
            }
            return response.json();
        })
        .then(data => {
  
            const table = document.getElementById("registros");
            const bodyTable = table.querySelector("tbody");


            bodyTable.innerHTML = "";


            data.logs.forEach(log => {
                const newRow = document.createElement("tr");
                const cellDate = document.createElement("td");
                const cellDescription = document.createElement("td");
                cellDate.textContent = log.date;
                cellDescription.textContent = log.description;
                newRow.appendChild(cellDate);
                newRow.appendChild(cellDescription);
                bodyTable.appendChild(newRow);
            });
        })
        .catch(error => {
            console.error('Error:', error);
      
        });
}
