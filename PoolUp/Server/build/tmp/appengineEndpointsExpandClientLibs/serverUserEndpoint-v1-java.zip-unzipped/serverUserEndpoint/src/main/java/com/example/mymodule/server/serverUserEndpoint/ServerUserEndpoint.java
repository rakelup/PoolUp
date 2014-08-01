/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2014-07-22 21:53:01 UTC)
 * on 2014-08-01 at 05:36:22 UTC 
 * Modify at your own risk.
 */

package com.example.mymodule.server.serverUserEndpoint;

/**
 * Service definition for ServerUserEndpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link ServerUserEndpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class ServerUserEndpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.19.0 of the serverUserEndpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://graphite-buffer-657.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "serverUserEndpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public ServerUserEndpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  ServerUserEndpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getServerUser".
   *
   * This request holds the parameters needed by the serverUserEndpoint server.  After setting any
   * optional parameters, call the {@link GetServerUser#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetServerUser getServerUser(java.lang.Long id) throws java.io.IOException {
    GetServerUser result = new GetServerUser(id);
    initialize(result);
    return result;
  }

  public class GetServerUser extends ServerUserEndpointRequest<com.example.mymodule.server.serverUserEndpoint.model.ServerUser> {

    private static final String REST_PATH = "serveruser/{id}";

    /**
     * Create a request for the method "getServerUser".
     *
     * This request holds the parameters needed by the the serverUserEndpoint server.  After setting
     * any optional parameters, call the {@link GetServerUser#execute()} method to invoke the remote
     * operation. <p> {@link GetServerUser#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetServerUser(java.lang.Long id) {
      super(ServerUserEndpoint.this, "GET", REST_PATH, null, com.example.mymodule.server.serverUserEndpoint.model.ServerUser.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetServerUser setAlt(java.lang.String alt) {
      return (GetServerUser) super.setAlt(alt);
    }

    @Override
    public GetServerUser setFields(java.lang.String fields) {
      return (GetServerUser) super.setFields(fields);
    }

    @Override
    public GetServerUser setKey(java.lang.String key) {
      return (GetServerUser) super.setKey(key);
    }

    @Override
    public GetServerUser setOauthToken(java.lang.String oauthToken) {
      return (GetServerUser) super.setOauthToken(oauthToken);
    }

    @Override
    public GetServerUser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetServerUser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetServerUser setQuotaUser(java.lang.String quotaUser) {
      return (GetServerUser) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetServerUser setUserIp(java.lang.String userIp) {
      return (GetServerUser) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetServerUser setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetServerUser set(String parameterName, Object value) {
      return (GetServerUser) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertServerUser".
   *
   * This request holds the parameters needed by the serverUserEndpoint server.  After setting any
   * optional parameters, call the {@link InsertServerUser#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.example.mymodule.server.serverUserEndpoint.model.ServerUser}
   * @return the request
   */
  public InsertServerUser insertServerUser(com.example.mymodule.server.serverUserEndpoint.model.ServerUser content) throws java.io.IOException {
    InsertServerUser result = new InsertServerUser(content);
    initialize(result);
    return result;
  }

  public class InsertServerUser extends ServerUserEndpointRequest<com.example.mymodule.server.serverUserEndpoint.model.ServerUser> {

    private static final String REST_PATH = "serveruser";

    /**
     * Create a request for the method "insertServerUser".
     *
     * This request holds the parameters needed by the the serverUserEndpoint server.  After setting
     * any optional parameters, call the {@link InsertServerUser#execute()} method to invoke the
     * remote operation. <p> {@link InsertServerUser#initialize(com.google.api.client.googleapis.servi
     * ces.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link com.example.mymodule.server.serverUserEndpoint.model.ServerUser}
     * @since 1.13
     */
    protected InsertServerUser(com.example.mymodule.server.serverUserEndpoint.model.ServerUser content) {
      super(ServerUserEndpoint.this, "POST", REST_PATH, content, com.example.mymodule.server.serverUserEndpoint.model.ServerUser.class);
    }

    @Override
    public InsertServerUser setAlt(java.lang.String alt) {
      return (InsertServerUser) super.setAlt(alt);
    }

    @Override
    public InsertServerUser setFields(java.lang.String fields) {
      return (InsertServerUser) super.setFields(fields);
    }

    @Override
    public InsertServerUser setKey(java.lang.String key) {
      return (InsertServerUser) super.setKey(key);
    }

    @Override
    public InsertServerUser setOauthToken(java.lang.String oauthToken) {
      return (InsertServerUser) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertServerUser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertServerUser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertServerUser setQuotaUser(java.lang.String quotaUser) {
      return (InsertServerUser) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertServerUser setUserIp(java.lang.String userIp) {
      return (InsertServerUser) super.setUserIp(userIp);
    }

    @Override
    public InsertServerUser set(String parameterName, Object value) {
      return (InsertServerUser) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link ServerUserEndpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link ServerUserEndpoint}. */
    @Override
    public ServerUserEndpoint build() {
      return new ServerUserEndpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link ServerUserEndpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setServerUserEndpointRequestInitializer(
        ServerUserEndpointRequestInitializer serveruserendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(serveruserendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
