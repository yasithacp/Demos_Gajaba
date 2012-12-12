
/**
 * SampleServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.org;

    /**
     *  SampleServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SampleServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SampleServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SampleServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getAllJSON method
            * override this method for handling normal response from getAllJSON operation
            */
           public void receiveResultgetAllJSON(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllJSON operation
           */
            public void receiveErrorgetAllJSON(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllJSONForUser method
            * override this method for handling normal response from getAllJSONForUser operation
            */
           public void receiveResultgetAllJSONForUser(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllJSONForUser operation
           */
            public void receiveErrorgetAllJSONForUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertMessage method
            * override this method for handling normal response from insertMessage operation
            */
           public void receiveResultinsertMessage(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertMessage operation
           */
            public void receiveErrorinsertMessage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for publish method
            * override this method for handling normal response from publish operation
            */
           public void receiveResultpublish(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from publish operation
           */
            public void receiveErrorpublish(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for searchAllJSON method
            * override this method for handling normal response from searchAllJSON operation
            */
           public void receiveResultsearchAllJSON(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from searchAllJSON operation
           */
            public void receiveErrorsearchAllJSON(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllXMLForUser method
            * override this method for handling normal response from getAllXMLForUser operation
            */
           public void receiveResultgetAllXMLForUser(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllXMLForUser operation
           */
            public void receiveErrorgetAllXMLForUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getIPAddress method
            * override this method for handling normal response from getIPAddress operation
            */
           public void receiveResultgetIPAddress(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getIPAddress operation
           */
            public void receiveErrorgetIPAddress(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for searchAllXML method
            * override this method for handling normal response from searchAllXML operation
            */
           public void receiveResultsearchAllXML(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from searchAllXML operation
           */
            public void receiveErrorsearchAllXML(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllXML method
            * override this method for handling normal response from getAllXML operation
            */
           public void receiveResultgetAllXML(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllXML operation
           */
            public void receiveErrorgetAllXML(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getXML method
            * override this method for handling normal response from getXML operation
            */
           public void receiveResultgetXML(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getXML operation
           */
            public void receiveErrorgetXML(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for logIn method
            * override this method for handling normal response from logIn operation
            */
           public void receiveResultlogIn(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from logIn operation
           */
            public void receiveErrorlogIn(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createUser method
            * override this method for handling normal response from createUser operation
            */
           public void receiveResultcreateUser(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createUser operation
           */
            public void receiveErrorcreateUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getJSON method
            * override this method for handling normal response from getJSON operation
            */
           public void receiveResultgetJSON(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getJSON operation
           */
            public void receiveErrorgetJSON(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getGroup method
            * override this method for handling normal response from getGroup operation
            */
           public void receiveResultgetGroup(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getGroup operation
           */
            public void receiveErrorgetGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCurrentUser method
            * override this method for handling normal response from getCurrentUser operation
            */
           public void receiveResultgetCurrentUser(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCurrentUser operation
           */
            public void receiveErrorgetCurrentUser(java.lang.Exception e) {
            }
                


    }
    