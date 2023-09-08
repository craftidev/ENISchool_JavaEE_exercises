document.addEventListener("DOMContentLoaded", function() {
    const actionTriggers = document.querySelectorAll(".action-trigger");
    const contentDiv = document.getElementById("contentDiv");

    // Menu links
    actionTriggers.forEach(function(trigger) {
        trigger.addEventListener("click", function(e) {
            e.preventDefault();
            const action = trigger.getAttribute("data-action");

            fetch(`SPAServlet?action=${action}`)
                .then(response => {
                    if (!response.ok) {
                        console.error(`HTTP error! Status: ${response.status}`);
                    }
                    return response.text();
                })
                .then(data => {
                    contentDiv.innerHTML = data;
                })
                .catch(error => {
                    console.error("Error:", error);
                });
        });
    });

    // Same for dinamicly generated form
    document.body.addEventListener("submit", function(e) {
        e.preventDefault();
        const formAction = e.target.getAttribute("action");
        const action = e.target.getAttribute("data-action");
        const method = e.target.getAttribute("method");
        const form = document.querySelector(".dynamic-form");
        const formData = new FormData(form);
        
        fetch(`${formAction}?action=${action}`, {
            method: method,
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: new URLSearchParams(formData).toString()
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.text();
            })
            .then(data => {
                contentDiv.innerHTML = data;
            })
            .catch(error => {
                console.error("Error:", error);
            });
    });
});
