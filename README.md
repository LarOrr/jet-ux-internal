### Task for JetBrains Internships 2021
Project - User experience improvements in internal product (backend) 


Api with Spring Boot + Kotlin

Request examples:

**POST /templates** - saves template in database
```
{

    "templateId": "internshipRequest",

    "template": "Jetbrains Internship in $teamName$ team.",

    "recipients": ["https://httpbin.org/post"]

}
```

**POST /templates/sendMessage** - sends messages to all recipients
```
{
    "templateId": "internshipRequest",
    "variables": {"teamName": "Analytics Platform"}
}
```
Note: From REST point of view, it is better to do "/<templateID>/sendMessage", but this contradicts the task condition
