<?xml version="1.0" encoding="UTF-8"?>
<!--
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
-->
<stylesheet version="1.0" xmlns="http://www.w3.org/1999/XSL/Transform"
            xmlns:ns="http://www.packtpub.com/LiveRestaurant/OrderService/schema">
    <output method="xml" encoding="UTF-8"/>
    <template match="/">
        <ns:OrderResponse>
             <attribute name="message"  ><value-of select="/ns:OrderResponse/ns:message"/></attribute>
        </ns:OrderResponse>
    </template>
</stylesheet>
