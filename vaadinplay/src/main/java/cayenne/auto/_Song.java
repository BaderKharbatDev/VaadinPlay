package cayenne.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

import cayenne.Party;

/**
 * Class _Song was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Song extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final Property<LocalDateTime> CREATED = Property.create("created", LocalDateTime.class);
    public static final Property<LocalDateTime> LAST_MODIFIED = Property.create("lastModified", LocalDateTime.class);
    public static final Property<String> NAME = Property.create("name", String.class);
    public static final Property<String> ARTIST_NAME = Property.create("artistName", String.class);
    public static final Property<List<Party>> PARTIES = Property.create("parties", List.class);

    protected LocalDateTime created;
    protected LocalDateTime lastModified;
    protected String name;
    protected String artistName;

    protected Object parties;

    public void setCreated(LocalDateTime created) {
        beforePropertyWrite("created", this.created, created);
        this.created = created;
    }

    public LocalDateTime getCreated() {
        beforePropertyRead("created");
        return this.created;
    }

    public void setLastModified(LocalDateTime lastModified) {
        beforePropertyWrite("lastModified", this.lastModified, lastModified);
        this.lastModified = lastModified;
    }

    public LocalDateTime getLastModified() {
        beforePropertyRead("lastModified");
        return this.lastModified;
    }

    public void setName(String name) {
        beforePropertyWrite("name", this.name, name);
        this.name = name;
    }

    public String getName() {
        beforePropertyRead("name");
        return this.name;
    }

    public void setArtistName(String artistName) {
        beforePropertyWrite("artistName", this.artistName, artistName);
        this.artistName = artistName;
    }

    public String getArtistName() {
        beforePropertyRead("artistName");
        return this.artistName;
    }

    public void addToParties(Party obj) {
        addToManyTarget("parties", obj, true);
    }

    public void removeFromParties(Party obj) {
        removeToManyTarget("parties", obj, true);
    }

    @SuppressWarnings("unchecked")
    public List<Party> getParties() {
        return (List<Party>)readProperty("parties");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "created":
                return this.created;
            case "lastModified":
                return this.lastModified;
            case "name":
                return this.name;
            case "artistName":
                return this.artistName;
            case "parties":
                return this.parties;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "created":
                this.created = (LocalDateTime)val;
                break;
            case "lastModified":
                this.lastModified = (LocalDateTime)val;
                break;
            case "name":
                this.name = (String)val;
                break;
            case "artistName":
                this.artistName = (String)val;
                break;
            case "parties":
                this.parties = val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.created);
        out.writeObject(this.lastModified);
        out.writeObject(this.name);
        out.writeObject(this.artistName);
        out.writeObject(this.parties);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.created = (LocalDateTime)in.readObject();
        this.lastModified = (LocalDateTime)in.readObject();
        this.name = (String)in.readObject();
        this.artistName = (String)in.readObject();
        this.parties = in.readObject();
    }

}