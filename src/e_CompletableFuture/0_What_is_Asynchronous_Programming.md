
# Synchronous 

    If an API call is synchronous, 
    It means that code execution will block (or wait) for the API call to return before continuing. 
    This means that until a response is returned by the API, your application will not execute any further, 
    which could be perceived by the user as latency or performance lag in your app.
 
 
# A-Synchronous

    Asynchronous calls do not block (or wait) for the API call to return from the server. 
    Execution continues on in your program, and when the call returns from the server, a “callback” function is executed.
  
    Asynchronous programming is a form of parallel programming that allows a unit of work to run separately from the primary application thread. 
    When the work is complete, it notifies the main thread (as well as whether the work was completed or failed). 
    There are numerous benefits to using it, such as improved application performance and enhanced responsiveness.
