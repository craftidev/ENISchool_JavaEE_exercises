<%@
    page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main menu - exercises</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/crud.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="bundle.js"></script>
</head>
<body>
    <h1>&#8801; List of applications / Exercises</h1>
    <menu>
        <a href="#contentDiv" class="linkExercises action-trigger" data-action="getUserAgentInfos">1. Get user agent infos</a>
        <a href="#contentDiv" class="linkExercises action-trigger" data-action="playGuessGame">2. Guess between 1 & 10</a>
        <a href="#contentDiv" class="linkExercises action-trigger" data-action="playJanken">3. Janken Game</a>
        <a href="#contentDiv" class="linkExercises action-trigger" data-action="crud">4. CRUD Meal composition/diary</a>
        <a href="" class="linkExercises">5.</a>
    </menu>

    <hr>

    <main>
        <div id="contentDiv"><!-- SPA content generated here --></div>
    </main>
</body>
</html>