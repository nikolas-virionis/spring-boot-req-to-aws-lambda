import json

# although the event is received as a JSON object, aws is nice enough to convert it to a dictionary, but its contents (body, for example), still remain as a JSON object, therefore, we need to convert it to a dictionary too. and the response can be a dictionary, which aws will reconvert into a JSON object
def lambda_handler(event, context):
    event = json.loads(event['body'])
    event['response'] = 'Hello from Lambda'
    return event
