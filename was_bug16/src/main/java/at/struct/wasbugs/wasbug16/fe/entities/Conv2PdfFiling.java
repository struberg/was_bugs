package at.struct.wasbugs.wasbug16.fe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * JPA Entity: pdf convert Job (Table CONV2PDF_FILES).
 * <p/>
 * 1..n Relation to CONV2PDF Files.
 *
 * @author KIH
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Conv2PdfFiling.QRY_FIND_READY, query = "SELECT f FROM Conv2PdfFiling f WHERE f.source = 2 AND f.statusCode = "
                + Conv2PdfFiling.STATUS_READY + " AND f.errorCode IS NULL"),
        @NamedQuery(name = Conv2PdfFiling.QRY_SET_STATUS, query = "UPDATE Conv2PdfFiling f SET f.statusCode = :status WHERE f.id = :id")
})
@Table(name = "CONV2PDF_FILINGS")
public class Conv2PdfFiling implements Serializable {

    public static final String QRY_FIND_READY = "Conv2PdfFiling.findReady";
    public static final String QRY_SET_STATUS = "Conv2PdfFiling.setStatus";

    public static final int STATUS_READY = 200;
    public static final int STATUS_OK = 300;
    public static final int STATUS_FAILED = 301;

    private static final long serialVersionUID = 8033227014389896832L;

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "PRIO", precision = 2)
    private Integer prio;

    @Column(name = "LOCK_ID")
    private String lockId;

    @Column(name = "LOCK_TIMESTAMP")
    private Date lockTimestamp;

    @Column(name = "SOURCE", precision = 2)
    private Integer source;

    @Column(name = "START_TIMESTAMP")
    private Date startTimestamp;

    @Column(name = "FINISH_TIMESTAMP")
    private Date finishTimestamp;

    @Column(name = "STATUS_CODE", precision = 3)
    private Integer statusCode;

    @Column(name = "ERROR_CODE", precision = 3)
    private Integer errorCode;

    @Column(name = "ERROR_MESSAGE", length = 1024)
    private String errorMessage;

    @Column(name = "FOLDER", length = 500)
    private String folder;

    @Column(name = "SOURCE_FILES_COUNT", precision = 4)
    private Integer sourceFilesCount;

    @Column(name = "DEST_FILE_NAME")
    private String destFileName;

    @Column(name = "DEST_PAGE_COUNT", precision = 4)
    private Integer destPageCount;

    @Column(name = "retry_count", precision = 2)
    private Integer retryCount;

    @Column(name = "TARGET_FORMAT", length = 50)
    private String targetFormat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getPrio() {
        return prio;
    }

    public void setPrio(Integer prio) {
        this.prio = prio;
    }

    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    public Date getLockTimestamp() {
        return lockTimestamp;
    }

    public void setLockTimestamp(Date lockTimestamp) {
        this.lockTimestamp = lockTimestamp;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Date getFinishTimestamp() {
        return finishTimestamp;
    }

    public void setFinishTimestamp(Date finishTimestamp) {
        this.finishTimestamp = finishTimestamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public Integer getSourceFilesCount() {
        return sourceFilesCount;
    }

    public void setSourceFilesCount(Integer sourceFilesCount) {
        this.sourceFilesCount = sourceFilesCount;
    }

    public String getDestFileName() {
        return destFileName;
    }

    public void setDestFileName(String destFileName) {
        this.destFileName = destFileName;
    }

    public Integer getDestPageCount() {
        return destPageCount;
    }

    public void setDestPageCount(Integer destPageCount) {
        this.destPageCount = destPageCount;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public String getTargetFormat() {
        return targetFormat;
    }

    public void setTargetFormat(String targetFormat) {
        this.targetFormat = targetFormat;
    }
}
