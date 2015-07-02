/*
 * Copyright 2015 Phil Bayfield https://philio.me
 * Copyright 2015 Piwigo Team http://piwigo.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.piwigo.io;

import org.piwigo.io.response.AddSuccessResponse;
import org.piwigo.io.response.StatusResponse;
import org.piwigo.io.response.SuccessResponse;

import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;

public interface RestService {

    @POST("/ws.php?method=pwg.categories.add")
    @FormUrlEncoded
    Observable<AddSuccessResponse> addCategory(
            @Field("name") String name,
            @Field("parent") Integer parent,
            @Field("comment") String comment,
            @Field("visible") Boolean visible,
            @Field("status") String status,
            @Field("commentable") Boolean commentable);

    @GET("/ws.php?method=pwg.session.getStatus")
    Observable<StatusResponse> getStatus();

    @POST("/ws.php?method=pwg.session.login")
    @FormUrlEncoded
    Observable<Response> login(
            @Field("username") String username,
            @Field("password") String password);

    @GET("/ws.php?method=pwg.session.logout")
    Observable<SuccessResponse> logout();

}