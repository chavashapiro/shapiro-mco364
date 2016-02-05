package shapiro.mco364.todo;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ToDoServiceTest {

	@Test
	public void testListTodos() throws IOException {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://jsonplaceholder.typicode.com")
				.addConverterFactory(GsonConverterFactory.create()).build();

		ToDoService service = retrofit.create(ToDoService.class);
		Call<List<Todo>> call = service.listTodos();
		
		Response<List<Todo>> response = call.execute();
		List<Todo> todos = response.body();
		Assert.assertTrue(todos.size() == 200);
	}
}
