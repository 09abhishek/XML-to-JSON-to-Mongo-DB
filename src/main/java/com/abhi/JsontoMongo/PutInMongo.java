package com.abhi.JsontoMongo;

import java.net.UnknownHostException;

import org.json.JSONException;

import com.abhi.ParseXMLToJson.ConvertToJson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;



public class PutInMongo {
	public static void main(String[] args) throws JSONException, Exception {
		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("mydb");
			DBCollection collection = db.getCollection("xmldump");

			//Getting the json in the pretty text format
			String sjson=ConvertToJson.JsonConversion();
			
			// convert JSON to DBObject
			DBObject dbObject = (DBObject)JSON.parse(sjson);
			
			//Inserting the object into collection.
			collection.insert(dbObject);
			
			// printing the inserted document into the collection of Mongodb
			DBCursor cursorDoc = collection.find();
			
			while (cursorDoc.hasNext()) {
				System.out.println(cursorDoc.next());
			}
			System.out.println("Done");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}
}