package com.packtpub.liverestaurant.service.security;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
/* Security & JAAS imports */
import java.security.Principal;



public class RdbmsPrincipal implements Principal, java.io.Serializable {

    private String name;

   
    public RdbmsPrincipal() {
        this("");
    }

   
    public RdbmsPrincipal(String newName) {
        name = newName;
    }

       public boolean equals(Object o) {

        if (o == null)
            return false;

        if (this == o)
            return true;
 
        if (o instanceof RdbmsPrincipal) {
            if (((RdbmsPrincipal) o).getName().equals(name))
                return true;
            else
                return false;
        }
        else 
            return false;
    }

       public String toString() {
        return name;
    }

   
    public String getName() {
        return name;
    }
}

