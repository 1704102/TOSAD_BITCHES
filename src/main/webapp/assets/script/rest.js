function postCall(input, rest, dataType) {
    var output = "";
    $.ajax({
        type: 'POST',
        url: rest,
        dataType: dataType,
        async: false,
        contentType: 'application/json',
        processData: true,
        data: JSON.stringify(input),
        success: function(data) {
            output = data;
        }
    });
    return output;
}

function putCall(input, rest) {
    var output = JSON.parse("{}");
    $.ajax({
        type: 'PUT',
        url: rest,
        async: false,
        processData: true,
        data: JSON.stringify(input),
        contentType: 'application/json',
        dataType: 'json',
        success: function(data) {
            output = data;
        }
    });
    console.log(output);
    return output;
}

function deleteCall(input, rest) {
    var output = "";
    $.ajax({
        type: 'DELETE',
        url: rest,
        data: JSON.stringify(input),
        contentType: 'application/json'
    });
    return output;
}

/**
 * Created by midisnake on 28-8-2018.
 */
