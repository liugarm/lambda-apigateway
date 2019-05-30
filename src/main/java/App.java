
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class App{

	//static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static Object handleRequest(Request request, Context context) throws ResourceNotFoundException {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		Consumption consumption = null;
		if(request.getHttpMethod().equals("GET")) {
			consumption = mapper.load(Consumption.class, request.getId());
			if (consumption == null) {
				throw new ResourceNotFoundException("Resource not found:" + request.getId());
			}
			return consumption;
		}
		else if(request.getHttpMethod().equals("POST")) {
			consumption = request.getConsumption();
			mapper.save(consumption);
			return consumption;
		} else {
			//throw exception if called method is not implemented
		}
		return null;
	}
}