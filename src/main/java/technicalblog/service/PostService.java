package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
//    @PersistenceUnit(unitName = "techblog")
//    private EntityManagerFactory emf;
    @Autowired
    private PostRepository repository;

    public List<Post> getAllPosts()  {

        return repository.getAllPosts();

        //ArrayList <Post> posts = new ArrayList<Post>();

//        Post post1 = new Post ();
//        post1.setTitle("Post 1");
//        post1.setBody("Post Body 1");
//        post1.setDate(new Date());
//
//        Post post2 = new Post ();
//        post2.setTitle("Post 2");
//        post2.setBody("Post Body 2");
//        post2.setDate(new Date());
//
//        Post post3 = new Post ();
//        post3.setTitle("Post 3");
//        post3.setBody("Post Body 3");
//        post3.setDate(new Date());
//
//        posts.add (post1);
//        posts.add (post2);
//        posts.add (post3);

//        EntityManager em = emf.createEntityManager();
//        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
//        List<Post> resultList = query.getResultList();
//        Connection connection = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//
//        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres", "postgres5432");
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery("SELECT * FROM posts");
//        while(rs.next()){
//            Post post = new Post();
//            post.setTitle(rs.getString("title"));
//            post.setBody(rs.getString("body"));
//            posts.add(post);
//        }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return posts;
        //return resultList;

    }

    //public ArrayList<Post> getOnePost() {
    public Post getOnePost() {
        return repository.getLatestPost();
       // ArrayList<Post> posts = new ArrayList<>();

//        Post post1 = new Post();
//        post1.setTitle("This is your Post");
//        post1.setBody("This is your Post. It has some valid content");
//        post1.setDate(new Date());
//        posts.add(post1);
//        Connection connection = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres", "postgres5432");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM posts where id=4");
//            while(rs.next()){
//                Post post = new Post();
//                post.setTitle(rs.getString("title"));
//                post.setBody(rs.getString("body"));
//                posts.add(post);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return posts;

    }
    public void createPost (Post newPost){
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println ("New Post: "+newPost);
    }

    public Post getPost(Integer postId) {
        return repository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }
    public void deletePost(Integer postId) {
        repository.deletePost(postId);
    }
}
