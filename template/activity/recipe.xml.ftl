<?xml version="1.0"?>
<recipe>

	<instantiate from="root/src/app_package/BusyboxActivity.java.ftl"
		to="${escapeXmlAttribute(srcOut)}/${actName}.java" />

	<instantiate from="root/src/app_package/BusyboxViewMode.java.ftl"
		to="${escapeXmlAttribute(srcOut)}/${vmName}.java" />

	<instantiate from="root/res/layout/activity_busybox.xml.ftl"
		to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />

    <merge from="root/AndroidManifest.xml.ftl"
        to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

    
</recipe>