<%@
    page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"
%>


<%!
    String[] movePool = {"rock", "scissors", "paper"};
    int score = 0;
    String aiMove;
    String userMove;
%>

<%
    aiMove = request.getParameter("aiMove");
    userMove = request.getParameter("userMove");
    request.setAttribute("aiMove", aiMove);
    request.setAttribute("userMove", userMove);
%>

<%!
    private void setNewAiMove() {
        int randIx = (int) (Math.random() * (2 + 1));
        aiMove = movePool[randIx];
    }

    private String getUserUiMessage() {
        String message;

        if (userMove == null) {
            message = "Start of the game, chose a move.";
        }
        else if (userMove.equals(aiMove)) {
            message = "It's a draw, you can play again.";
        }
        else if (isWinning(userMove)) {
            message = "You win this time, you can play again.";
        }
        else {
            message = "You lose this time, you can play again.";
        }

        setNewAiMove();
        return message;
    }

    private boolean isWinning(String userMove) {
        boolean result = true;

        if (userMove.equals("rock")) {
            if (aiMove.equals("paper")) {
                result = false;
            }
        }
        else if (userMove.equals("scissors")) {
            if (aiMove.equals("rock")) {
                result = false;
            }
        }
        else {
            if (aiMove.equals("scissors")) {
                result = false;
            }
        }

        return result;
    }

%>

<h2>Janken game</h2>

<p><%= getUserUiMessage() %></p>

<form method="POST" action="WelcomeServlet" data-action="playJanken" class="dynamic-form">
<select name="userMove" size="3">
    <option value="rock">&#9994;</option>
    <option value="paper">&#9995;</option>
    <option value="scissors">&#9996;</option>
</select>
<input type="hidden" name="aiMove" value="<%= aiMove %>">
<input type="submit">
</form>

<%-- !Test --%>
user move: ${userMove}<br>
ai move: ${aiMove}<br>
