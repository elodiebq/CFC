var data = $("#data").html();
var label = $("#label").html();
var datas = data.substring(0,data.length-1).split(',');
var labels = label.substring(0,label.length-1).split(',');
var lineChartData = {
	labels : labels,
	datasets : [
		{
			fillColor : "rgba(220,220,220,0.5)",
			strokeColor : "rgba(220,220,220,1)",
			pointColor : "rgba(220,220,220,1)",
			pointStrokeColor : "#fff",
			data : datas
		}
	]
};


var ctx = $("#myChart").get(0).getContext("2d");
new Chart(ctx).Line(lineChartData);