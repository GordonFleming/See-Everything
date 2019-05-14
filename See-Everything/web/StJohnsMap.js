/* 
    Created on : Apr 28, 2019, 1:52:21 PM
    Author     : gordonfleming
*/
 /* global locations */

var venues=[
{"VENUEID":"1","NAME":"Afrikaans 17","SHORT":"17"},
{"VENUEID":"2","NAME":"Afrikaans 28","SHORT":"28"},
{"VENUEID":"3","NAME":"Afrikaans 29","SHORT":"29"},
{"VENUEID":"4","NAME":"Afrikaans 30","SHORT":"30"},
{"VENUEID":"5","NAME":"Afrikaans 31","SHORT":"31"},
{"VENUEID":"6","NAME":"Afrikaans 32","SHORT":"32"},
{"VENUEID":"20","NAME":"Art 33","SHORT":"33"},
{"VENUEID":"21","NAME":"Art 36","SHORT":"36"},
{"VENUEID":"40","NAME":"Drama 70","SHORT":"70"},
{"VENUEID":"41","NAME":"Drama Alternate","SHORT":"DraAlt"},
{"VENUEID":"42","NAME":"Drama Dungeon","SHORT":"Dun"},
{"VENUEID":"60","NAME":"English 1","SHORT":"E1"},
{"VENUEID":"61","NAME":"English 2","SHORT":"E2"},
{"VENUEID":"62","NAME":"English 3","SHORT":"E3"},
{"VENUEID":"63","NAME":"English 4","SHORT":"E4"},
{"VENUEID":"64","NAME":"English 5","SHORT":"E5"},
{"VENUEID":"65","NAME":"English 6","SHORT":"E6"},
{"VENUEID":"66","NAME":"English 7","SHORT":"E7"},
{"VENUEID":"67","NAME":"English 8","SHORT":"E8"},
{"VENUEID":"75","NAME":"FOE 13","SHORT":"B13"},
{"VENUEID":"90","NAME":"Geography 1","SHORT":"G1"},
{"VENUEID":"91","NAME":"Geography 2","SHORT":"G2"},
{"VENUEID":"92","NAME":"Geography 3","SHORT":"G3"},
{"VENUEID":"93","NAME":"Geography 4","SHORT":"G4"},
{"VENUEID":"94","NAME":"German 64","SHORT":"64"},
{"VENUEID":"120","NAME":"History 7","SHORT":"His7"},
{"VENUEID":"121","NAME":"History 8","SHORT":"His8"},
{"VENUEID":"122","NAME":"History 9","SHORT":"His9"},
{"VENUEID":"123","NAME":"History 12","SHORT":"His12"},
{"VENUEID":"124","NAME":"History 12B","SHORT":"His12B"},
{"VENUEID":"140","NAME":"Information Technology 15","SHORT":"B15"},
{"VENUEID":"141","NAME":"Information Technology 16","SHORT":"B16"},
{"VENUEID":"142","NAME":"Information Technology REB","SHORT":"REB"},
{"VENUEID":"160","NAME":"Latin 9","SHORT":"E9"},
{"VENUEID":"190","NAME":"Life Orientation 24","SHORT":"24"},
{"VENUEID":"191","NAME":"Life Sciences 4","SHORT":"B4"},
{"VENUEID":"192","NAME":"Life Sciences 7","SHORT":"B7"},
{"VENUEID":"193","NAME":"Life Sciences 9","SHORT":"B9"},
{"VENUEID":"194","NAME":"Life Sciences 10","SHORT":"B10"},
{"VENUEID":"220","NAME":"Mathematics 14","SHORT":"Mat14"},
{"VENUEID":"221","NAME":"Mathematics 15","SHORT":"15"},
{"VENUEID":"222","NAME":"Mathematics 16","SHORT":"16"},
{"VENUEID":"223","NAME":"Mathematics 39","SHORT":"39"},
{"VENUEID":"224","NAME":"Mathematics 42","SHORT":"42"},
{"VENUEID":"225","NAME":"Mathematics 44","SHORT":"44"},
{"VENUEID":"226","NAME":"Mathematics 47","SHORT":"47"},
{"VENUEID":"227","NAME":"Mathematics 48","SHORT":"48"},
{"VENUEID":"228","NAME":"Mathematics 50","SHORT":"50"},
{"VENUEID":"240","NAME":"Divinity 59","SHORT":"59"},
{"VENUEID":"260","NAME":"French 60","SHORT":"60"},
{"VENUEID":"261","NAME":"French 61","SHORT":"61"},
{"VENUEID":"229","NAME":"Mathematics 67","SHORT":"67"},
{"VENUEID":"230","NAME":"Mathematics 69","SHORT":"69"},
{"VENUEID":"250","NAME":"Music 14","SHORT":"Mus14"},
{"VENUEID":"280","NAME":"Music Auditorium","SHORT":"MusAud"},
{"VENUEID":"281","NAME":"Music Green","SHORT":"MusGrn"},
{"VENUEID":"300","NAME":"Physical Education Field","SHORT":"Field"},
{"VENUEID":"301","NAME":"Physical Education Field 2","SHORT":"Field"},
{"VENUEID":"340","NAME":"Science 14","SHORT":"B14"},
{"VENUEID":"341","NAME":"Science C1","SHORT":"C1"},
{"VENUEID":"342","NAME":"Science C2","SHORT":"C2"},
{"VENUEID":"343","NAME":"Science C6","SHORT":"C6"},
{"VENUEID":"344","NAME":"Science P1","SHORT":"P1"},
{"VENUEID":"345","NAME":"Science P2","SHORT":"P2"},
{"VENUEID":"346","NAME":"Science P6","SHORT":"P6"},
{"VENUEID":"360","NAME":"Sixth Form 55","SHORT":"55"},
{"VENUEID":"380","NAME":"Zulu 65","SHORT":"65"},
{"VENUEID":"381","NAME":"Zulu 66","SHORT":"66"},
{"VENUEID":"22","NAME":"Art 35","SHORT":"35"},
{"VENUEID":"231","NAME":"Mathematics 14","SHORT":"14"},
];

var temp_array= venues.map(function(item){
    return item.VENUEID;
});
var highest_value = Math.max.apply(Math, temp_array);

$(function() {
    for(i = 0; i < venues.length; i++) {
        $('#'+ venues[i].SHORT)
        .css({'fill': 'rgba(5, 500, 5000,' + venues[i].VENUEID/highest_value +')'})
        .data('venue', venues[i]);
    }
    for(i = 0; i < locations.length; i++) {
        $('#'+ locations[i].VENUE)
        .data('locations',locations[i]);
    }

    $('.map g').mouseover(function (e) {
        var venue_data=$(this).data('venue');
        var locations_data=$(this).data('locations');
        $('<div class="info_panel">'+
            venue_data.NAME + '<br>' +
            'VenueID: ' + venue_data.VENUEID.toLocaleString("en-UK") + '<br>' +
            'StaffName: ' + locations_data.STAFFNAME + '<br>' +
            'Time: ' + locations_data.TIME +
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
            left: mouseX - ($('.info_panel').width()/0.8)
        });
    });

});