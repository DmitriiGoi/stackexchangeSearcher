var pageNumber = 1;
var div = $("#result-div");

$(document).ready(function () {
    $("#appendNextResultButton").hide();
});

function searchFunction() {
    div.html("");
    pageNumber = 1;
    $.ajax({
        type: "get",
        url: "/search",
        data: {
            query: document.getElementById('input-query').value
        },
        success: function (response) {
            appendResponse(response)
        },
        error: function (xhr) {
            showFail(xhr)
        }
    })
}

function appendResponse(response) {
    $.each(response.items, function (i, item) {
        if (item.is_answered) {
            div.append("&#9989;");
        } else {
            div.append("&#10008;");
        }
        div.append("<a href='" + item.link + "'>" + item.title + "</a><br/>");
    });

    if (response.has_more) {
        $("#appendNextResultButton").show();
    } else {
        $("#appendNextResultButton").hide();
    }
}

function appendNextResultFunction(){
    pageNumber = pageNumber+1;
    $.ajax({
        type: "get",
        url: "/search",
        data: {
            query: document.getElementById('input-query').value,
            page: pageNumber
        },
        success: function (response) {
            appendResponse(response)
        },
        error: function (xhr) {
            showFail(xhr)
        }
    })
}

function showFail(xhr) {
    div.append("<span style='background-color:red'>" + JSON.parse(xhr.responseText).error_message + "</span>");
    $("#appendNextResultButton").hide();
}