import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.work.forum.Main;
import ru.work.forum.model.Post;
import ru.work.forum.service.PostService;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.junit.Assert.assertThat;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControlTest {
    @MockBean
    private PostService posts;

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageCreate() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("create"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageEdit() throws Exception {
        this.mockMvc.perform(get("/edit?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception{
        this.mockMvc.perform(post("/save")
                        .param("name", "Куплю ладу-грант. Дорого."))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        ArgumentCaptor<String[]> argumentArr = ArgumentCaptor.forClass(String[].class);
        verify(posts).add(argument.capture(), argumentArr.capture());
        assertThat(argument.getValue().getName(), is("Куплю ладу-грант. Дорого."));
    }

}
