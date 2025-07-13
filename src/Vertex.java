import java.util.Objects;

public class Vertex {
    int id;

    Vertex(int id){
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) { //override to compare ids, not only memory locations
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vertex)) {
            return false;
        }

        Vertex other = (Vertex) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}

