package at.struct.wasbugs.wasbug16.fe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * JPA Entity: einzelner pdf converter Datei-Eintrag (Table CONV2PDF_FILES).
 *
 * @author KIH
 */
@Entity
@Table(name = "CONV2PDF_FILES")
public class Conv2PdfFile implements Serializable {

    private static final long serialVersionUID = -5546958235438145642L;

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "FILE_NAME", length = 100)
    private String fileName;

    @Column(name = "FILE_MIMETYPE", length = 100)
    private String fileMimeType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMimeType() {
        return fileMimeType;
    }

    public void setFileMimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
    }
}
