package postgr;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PetRepository {
    public void addPet(pet pet) {
        String sql = "INSERT INTO pets(name, age, status) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pet.getName());
            ps.setInt(2, pet.getAge());
            ps.setString(3, pet.getStatus());
            ps.executeUpdate();

            System.out.println("Pet added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<pet> getAllPets() {
        List<pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                pets.add(new pet(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pets;
    }
    public void updatePetStatus(int id, String status) {
        String sql = "UPDATE pets SET status=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Pet updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deletePet(int id) {
        String sql = "DELETE FROM pets WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Pet deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
