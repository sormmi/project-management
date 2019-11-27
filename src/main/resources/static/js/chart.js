
// chartData from java controller
const chartDataStr = decodeHtml(chartData);
const chartJsonArray = JSON.parse(chartDataStr);

const arrayLength = chartJsonArray.length;

let numericData = [];
let labels = [];

for(let i = 0; i < arrayLength; i++){
    numericData[i] = chartJsonArray[i].value;
    labels[i] = chartJsonArray[i].label;
}

// Pie chart
new Chart(document.getElementById("myChart"), {
    type: 'pie',
    data: {
        labels: labels,
        datasets: [{
            label: 'Project status data',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
        title: {
            display: true,
            text: 'Project Statuses'
        }
    }
});

// "[{"value": 1, "label": "COMPLETED"},{"value": 2, "label": "INPROGRESS"},{"value": 1, "label": "NOTSTARTED"}]"
function decodeHtml(html){
    let txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}