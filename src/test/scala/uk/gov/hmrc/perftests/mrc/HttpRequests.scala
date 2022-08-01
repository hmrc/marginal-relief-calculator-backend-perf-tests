/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.perftests.mrc

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration

object HttpRequests extends ServicesConfiguration {

  val baseUrl: String = baseUrlFor("marginal-relief-calculator-backend")
  val route: String   = "/marginal-relief-calculator-backend"

  val calculate: HttpRequestBuilder =
    http("Calculate marginal relief")
      .get(s"$baseUrl$route/calculate")
      .queryParam("accountingPeriodStart", "2024-01-01")
      .queryParam("accountingPeriodEnd", "2024-12-31")
      .queryParam("profit", "100000")
      .queryParam("exemptDistributions", "10000")
      .queryParam("associatedCompanies", "1")
      .check(status.is(200))

  val askParamsAssociatedCompanies: HttpRequestBuilder =
    http("Ask for associated company parameters")
      .get(s"$baseUrl$route/ask-params/associated-companies")
      .queryParam("accountingPeriodStart", "2024-01-01")
      .queryParam("accountingPeriodEnd", "2024-12-31")
      .queryParam("profit", "100000")
      .queryParam("exemptDistributions", "10000")
      .check(status.is(200))
}
