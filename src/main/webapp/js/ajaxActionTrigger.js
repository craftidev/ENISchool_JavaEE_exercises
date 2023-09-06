document.addEventListener("DOMContentLoaded", function() {
    const actionTriggers = document.querySelectorAll(".action-trigger");
    const contentDiv = document.getElementById("contentDiv");

    // Menu links
    actionTriggers.forEach(function(trigger) {
        trigger.addEventListener("click", function(e) {
            e.preventDefault();
            const action = trigger.getAttribute("data-action");

            fetch(`WelcomeServlet?action=${action}`)
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

    // Guessing game form
    document.body.addEventListener("submit", function(e) {
        if (e.target.classList.contains("guess-game-form")) {
            e.preventDefault();
            const formAction = e.target.getAttribute("action");
            const action = e.target.getAttribute("data-action");
            const userGuess = e.target.querySelector('input[name="userGuess"]').value;
            
            fetch(`${formAction}?action=${action}&userGuess=${userGuess}`, {
                method: "POST"
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
        }
    });
});

// $(document).ready(function() {
    // $(".action-trigger").click(function(e) {
    //     e.preventDefault();
    //     var action = $(this).data("action");

    //     $.ajax({
    //         url: "WelcomeServlet",
    //         data: { action: action },
    //         type: "GET",
    //         success: function(resp) {
    //             $("#contentDiv").html(resp);
    //         },
    //         error: function(xhr, status, error) {
    //             console.error("Error:", status, error);
    //         }
    //     });
    // });

    // Same but for dynamically generated guessing game form
//     $(document).on("submit", ".ajax-form", function(e) {
//         e.preventDefault();
//         var formAction = $(this).data("formAction");
//         var action = $(this).data("action");
//         var userGuess = $(this).find('input[name="userGuess"]').val()
        
//         $.ajax({
//             url: formAction,
//             data: { action: action, userGuess: userGuess },
//             type: "GET",
//             success: function(resp) {
//                 $("#contentDiv").html(resp);
//             },
//             error: function(xhr, status, error) {
//                 console.error("Error:", status, error);
//             }
//         });
//     });
// });

