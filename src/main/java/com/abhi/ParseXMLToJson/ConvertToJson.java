package com.abhi.ParseXMLToJson;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.abhi.LoadXMLFile.ReadXMLFile;

public class ConvertToJson {
	//The path to location of Data.xml
	public static String PATH = "D:/ExternalFileLink/MN_0023.xml";

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;


	public static String JsonConversion() throws Exception ,JSONException {

		// Read XML file content and save as String
		String textXML = ReadXMLFile.readXMLFile(PATH);
		// Declare a JsonObject and parse textXML to JsonObject
		JSONObject xmlJSONOBJECT = XML.toJSONObject(textXML);
		// Parse JsonObject to String for printing
		String jsonPrettyString = xmlJSONOBJECT.toString(PRETTY_PRINT_INDENT_FACTOR);
		System.out.println(jsonPrettyString);

		return jsonPrettyString;
	}
}

