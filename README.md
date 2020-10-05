# Quizo

Quizo service is running on a Docker and its configurations are mentioned in its docker file. The service is published on port 30080 from Docker.
<br><br>Quizo service exposes a GET endpoint /questions which gives a json of questions and /answers/{questionId}/{option} which is used to check the answer for the question.
<br><br>Quizo service internally invokes a GET request to Answero service which is running on port 30070 and exposes an endpoint /{questionId}/{option} which checks for the correct/incorrrect answer based on the option provided.
<br><br>
<br>URL:
GET Request to fetch the questions list: http://roost-controlplane:30080/questions
<br><br>[{"questionId":"1","question":"Which is the tallest mountain on earth?","optionA":"Mt Everest","optionB":"Mt Kilimanjaro","optionC":"Mt K2","optionD":"Mt Mauna Kea","note":"Single correct type question. Answer will be in single letter format: a/b/c/d"},{"questionId":"2","question":"The Tapti River is flowing from which of the following region?","optionA":"Satpura range","optionB":"Vindhyachal range","optionC":"Western Ghats","optionD":"Eastern Ghats","note":"Single correct type question. Answer will be in single letter format: a/b/c/d"},{"questionId":"3","question":"Which of the following river system created the Jog waterfalls?","optionA":"Tunga bhadra","optionB":"Sharavathi","optionC":"Koyna","optionD":"None of the above","note":"Single correct type question. Answer will be in single letter format: a/b/c/d"}]
<br><br>
Note can signify about the type of question, marking scheme or any other additional information that needs to be shared.
<br>
GET Request to check the answer for the questionId: http://roost-controlplane:30080/answer/1/c
<br><br>
This application is a basic example of communincation between two microservices hosted on Cloud Native platform.
