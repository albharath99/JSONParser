Sample project to demonstrate JSON parsing using JSONObject and JSONArray class.

Note:
I tried to run the JSON parse code in a main function in a kotlin file.
There was a run-time error. 
" Exception in thread "main" java.lang.RuntimeException: Stub!
	at org.json.JSONObject.<init>(JSONObject.java:115)"
Seems like in order to use this class, we need to initiate it from an activity/service and cannot do it from a standalone main function.  
