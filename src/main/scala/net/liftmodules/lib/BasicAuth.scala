/*
	Copyright 2011 Spiral Arm Ltd

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.package bootstrap.liftmodules
*/
package net.liftmodules.basicauth

import net.liftweb.common.{ Full, Loggable }
import net.liftweb.http.{ LiftRules, Req }
import net.liftweb.http.auth.AuthRole
import net.liftweb.http.auth._
import net.liftweb.util.Props

package lib {

  object BasicAuth extends Loggable {

    def init = {

      logger.debug("Auth enabled")

      val title = Props.get("liftmodules.basic.title").openOr("")
      val role = Props.get("liftmodules.basic.role").openOr("")
      val username = Props.get("liftmodules.basic.username").openOr("")
      val password = Props.get("liftmodules.basic.password").openOr("")

      LiftRules.authentication = HttpBasicAuthentication(title) {
        case (username, password, _) => userRoles(AuthRole(role) :: Nil); true
      }

      LiftRules.httpAuthProtectedResource.prepend {
        case Req(_, _, _) => Full(AuthRole(role))
      }

    }

  }

}

