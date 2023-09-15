document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("contentDiv").addEventListener("click", function(event) {
        if (event.target.classList.contains("button-select-crud")) {
            const divs = document.querySelectorAll(".form-appear-on-button");
            const targetId = event.target.getAttribute("data-target");
            const targetDiv = document.getElementById(targetId);
            
            divs.forEach(function(div) {
                if (!(div === targetDiv)) {
                    div.style.display = "none";
                }
            });
            targetDiv.style.display = targetDiv.style.display === "block" ? "none" : "block";
        }

        if (event.target.classList.contains("button-POST-editdelete")) {
            const servletAction = event.target.getAttribute("servlet-action");
            const elementId = event.target.getAttribute("element-id");

            fetch(`DBPoolConnectionServlet?action=${servletAction}&elementId=${elementId}`)
                .then(response => {
                    if (!response.ok) {
                        console.error(`HTTP error! Status: ${response.status}`);
                    }

                    return response.text();
                })
                .then(data => {
                    document.getElementById("contentDiv").innerHTML = data;
                })
                .catch(error => {
                    console.error("Error:", error);
                });
        }
    });
});