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

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.mrc.HttpRequests._

class MarginalReliefCalculatorSimulation extends PerformanceTestRunner {

  setup(
    "ask-params-associated-companies",
    "Ask for associated companies parameter"
  ) withRequests askParamsAssociatedCompanies

  setup("marginal-relief-calculation", "Marginal Relief Calculation") withRequests calculate

  setup(
    id= "config-year",
    description = "Check for config year"
  ) withRequests configYear

  runSimulation()
}
