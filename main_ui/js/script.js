$(document).ready(function() {
    addRequest("Request 1");
    addRequest("Request 2");
    addRequest("Request 3");
    addRequest("Request 4");
    addRequest("Request 5");
    addRequest("Request 6");
    addRequest("Request 7");
    addRequest("Request 8");
    addRequest("Request 9");
    addRequest("Request 10");
    addRule("Rule 1");
    addRule("Rule 2");
    addRule("Rule 3");
    addRule("Rule 4");
    addRule("Rule 5");
    addRule("Rule 6");

});

function addRequest(request){
    $('.requestSet').prepend('<div class="item"><div class="openclose" style="padding-left: 10px; vertical-align: middle;"></div><div class="name">'+request+'</div></div>');
}

function addRule(rule){
    $('.ruleSet').prepend('<div class="item"><div class="openclose" style="padding-left: 10px; vertical-align: middle;"></div><div class="name">'+rule+'</div></div>');
}