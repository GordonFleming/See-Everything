/* 
    Created on : Apr 28, 2019, 1:52:21 PM
    Author     : gordonfleming
*/
 var venues=[
{"VENUEID":"1","NAME":"Afrikaans 17","SHORT":"17"},
{"VENUEID":"2","NAME":"Afrikaans 28","SHORT":"28"},
{"VENUEID":"3","NAME":"Afrikaans 29","SHORT":"29"},
{"VENUEID":"4","NAME":"Afrikaans 30","SHORT":"30"},
{"VENUEID":"5","NAME":"Afrikaans 31","SHORT":"31"},
{"VENUEID":"6","NAME":"Afrikaans 32","SHORT":"32"},
{"VENUEID":"7","NAME":"Art 33","SHORT":"33"},
{"VENUEID":"8","NAME":"Art 36","SHORT":"36"},
{"VENUEID":"9","NAME":"Drama 70","SHORT":"70"},
{"VENUEID":"10","NAME":"Drama Alternate","SHORT":"DraAlt"},
{"VENUEID":"11","NAME":"Drama Dungeon","SHORT":"Dun"},
{"VENUEID":"12","NAME":"English 1","SHORT":"E1"},
{"VENUEID":"13","NAME":"English 2","SHORT":"E2"},
{"VENUEID":"14","NAME":"English 3","SHORT":"E3"},
{"VENUEID":"15","NAME":"English 4","SHORT":"E4"},
{"VENUEID":"16","NAME":"English 5","SHORT":"E5"},
{"VENUEID":"17","NAME":"English 6","SHORT":"E6"},
{"VENUEID":"18","NAME":"English 7","SHORT":"E7"},
{"VENUEID":"19","NAME":"English 8","SHORT":"E8"},
{"VENUEID":"20","NAME":"FOE 13","SHORT":"B13"},
{"VENUEID":"21","NAME":"Geography 1","SHORT":"G1"},
{"VENUEID":"22","NAME":"Geography 2","SHORT":"G2"},
{"VENUEID":"23","NAME":"Geography 3","SHORT":"G3"},
{"VENUEID":"24","NAME":"Geography 4","SHORT":"G4"},
{"VENUEID":"25","NAME":"German 64","SHORT":"64"},
{"VENUEID":"26","NAME":"History 7","SHORT":"His7"},
{"VENUEID":"27","NAME":"History 8","SHORT":"His8"},
{"VENUEID":"28","NAME":"History 9","SHORT":"His9"},
{"VENUEID":"29","NAME":"History 12","SHORT":"His12"},
{"VENUEID":"30","NAME":"History 12B","SHORT":"His12B"},
{"VENUEID":"31","NAME":"Information Technology 15","SHORT":"B15"},
{"VENUEID":"32","NAME":"Information Technology 16","SHORT":"B16"},
{"VENUEID":"33","NAME":"Information Technology REB","SHORT":"REB"},
{"VENUEID":"34","NAME":"Latin 9","SHORT":"E9"},
{"VENUEID":"35","NAME":"Life Orientation 24","SHORT":"24"},
{"VENUEID":"36","NAME":"Life Sciences 4","SHORT":"B4"},
{"VENUEID":"37","NAME":"Life Sciences 7","SHORT":"B7"},
{"VENUEID":"38","NAME":"Life Sciences 9","SHORT":"B9"},
{"VENUEID":"39","NAME":"Life Sciences 10","SHORT":"B10"},
{"VENUEID":"40","NAME":"Mathematics 14","SHORT":"Mat14"},
{"VENUEID":"41","NAME":"Mathematics 15","SHORT":"15"},
{"VENUEID":"42","NAME":"Mathematics 16","SHORT":"16"},
{"VENUEID":"43","NAME":"Mathematics 39","SHORT":"39"},
{"VENUEID":"44","NAME":"Mathematics 42","SHORT":"42"},
{"VENUEID":"45","NAME":"Mathematics 44","SHORT":"44"},
{"VENUEID":"46","NAME":"Mathematics 47","SHORT":"47"},
{"VENUEID":"47","NAME":"Mathematics 48","SHORT":"48"},
{"VENUEID":"48","NAME":"Mathematics 50","SHORT":"50"},
{"VENUEID":"49","NAME":"Divinity 59","SHORT":"59"},
{"VENUEID":"50","NAME":"French 60","SHORT":"60"},
{"VENUEID":"51","NAME":"French 61","SHORT":"61"},
{"VENUEID":"52","NAME":"Mathematics 67","SHORT":"67"},
{"VENUEID":"53","NAME":"Mathematics 69","SHORT":"69"},
{"VENUEID":"54","NAME":"Music 14","SHORT":"Mus14"},
{"VENUEID":"55","NAME":"Music Auditorium","SHORT":"MusAud"},
{"VENUEID":"56","NAME":"Music Green","SHORT":"MusGrn"},
{"VENUEID":"57","NAME":"Physical Education Field","SHORT":"Field"},
{"VENUEID":"58","NAME":"Physical Education Field 2","SHORT":"Field"},
{"VENUEID":"59","NAME":"Science 14","SHORT":"B14"},
{"VENUEID":"60","NAME":"Science C1","SHORT":"C1"},
{"VENUEID":"61","NAME":"Science C2","SHORT":"C2"},
{"VENUEID":"62","NAME":"Science C6","SHORT":"C6"},
{"VENUEID":"63","NAME":"Science P1","SHORT":"P1"},
{"VENUEID":"64","NAME":"Science P2","SHORT":"P2"},
{"VENUEID":"65","NAME":"Science P6","SHORT":"P6"},
{"VENUEID":"66","NAME":"Sixth Form 55","SHORT":"55"},
{"VENUEID":"67","NAME":"Zulu 65","SHORT":"65"},
{"VENUEID":"68","NAME":"Zulu 66","SHORT":"66"}
];

var temp_array= venues.map(function(item){
    return item.VENUEID;
});
var highest_value = Math.max.apply(Math, temp_array);

$(function() {
    for(i = 0; i < venues.length; i++) {
        $('#'+ venues[i].SHORT)
        .css({'fill': 'rgba(5, 500, 5000,' + venues[i].VENUEID/highest_value +')'})
        .data('region', venues[i]);
    }

    $('.map g').mouseover(function (e) {
        var venue_data=$(this).data('region');
        $('<div class="info_panel">'+
            venue_data.NAME + '<br>' +
            'VenueID: ' + venue_data.VENUEID.toLocaleString("en-UK") +
            '</div>'
         )
        .appendTo('body');
    })
    .mouseleave(function () {
        $('.info_panel').remove();
    })
    .mousemove(function(e) {
        var mouseX = e.pageX, //X coordinates of mouse
            mouseY = e.pageY; //Y coordinates of mouse

        $('.info_panel').css({
            top: mouseY-50,
            left: mouseX - ($('.info_panel').width()/2)
        });
    });

});