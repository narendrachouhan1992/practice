/**
 * 
 */
function solution() {
	var str = "";
	$('body>table>tbody>tr').each(function(){
		var c = $(this).find('td').prop('color');
		var bgc = $(this).find('td').prop('background-color');
		var data = $(this).find('td').text();
		if(c!=bgc)
			str+=data;
	});
	return str;
}