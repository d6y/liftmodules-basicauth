# Basic Auth Lift Module

Uses Basic Auth to control access to the whole of a [Lift](http://www.liftweb.net) application based on the run mode.  Useful, for example, when you want to restrict access to a site before launch or restrict access to a staging site.

## Using this module

1. Add the following repository to your SBT project file:

    For SBT 0.10:

        resolvers += "liftmodules repository" at "http://repository-liftmodules.forge.cloudbees.com/release/"

    For SBT 0.7:

        lazy val liftModulesRelease = "liftmodules repository" at "http://repository-liftmodules.forge.cloudbees.com/release/"

2. Include this dependency:

         "net.liftmodules" %% "basic-auth" % (liftVersion+"-1.1")

3. In your application's Boot.boot code:

          net.liftmodules.basicauth.lib.BasicAuth.init
          
          BasicAuth.auth
          
4. Finally, add the following properties to the properties files of the run mode you wish to be protected.   For example, add the following to `src/main/resources/production.default.props` 
If you want all run modes to have authentication put them in default.props 

         
         liftmodules.basic.title=Protected Site
         liftmodules.basic.role=Role
         liftmodules.basic.username=hello
         liftmodules.basic.password=hello


  
