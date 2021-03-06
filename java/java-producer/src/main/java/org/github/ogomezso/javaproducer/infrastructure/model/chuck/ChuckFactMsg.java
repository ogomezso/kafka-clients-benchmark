/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.github.ogomezso.scs.infrastructure.model.chuck;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ChuckFactMsg extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7727082176780821630L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ChuckFactMsg\",\"namespace\":\"org.github.ogomezso.scs.infrastructure.model.chuck\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"fact\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ChuckFactMsg> ENCODER =
      new BinaryMessageEncoder<ChuckFactMsg>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ChuckFactMsg> DECODER =
      new BinaryMessageDecoder<ChuckFactMsg>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ChuckFactMsg> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ChuckFactMsg> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ChuckFactMsg> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ChuckFactMsg>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ChuckFactMsg to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ChuckFactMsg from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ChuckFactMsg instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ChuckFactMsg fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence id;
  private long timestamp;
  private java.lang.CharSequence fact;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ChuckFactMsg() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param timestamp The new value for timestamp
   * @param fact The new value for fact
   */
  public ChuckFactMsg(java.lang.CharSequence id, java.lang.Long timestamp, java.lang.CharSequence fact) {
    this.id = id;
    this.timestamp = timestamp;
    this.fact = fact;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return timestamp;
    case 2: return fact;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: timestamp = (java.lang.Long)value$; break;
    case 2: fact = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return The value of the 'timestamp' field.
   */
  public long getTimestamp() {
    return timestamp;
  }


  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(long value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'fact' field.
   * @return The value of the 'fact' field.
   */
  public java.lang.CharSequence getFact() {
    return fact;
  }


  /**
   * Sets the value of the 'fact' field.
   * @param value the value to set.
   */
  public void setFact(java.lang.CharSequence value) {
    this.fact = value;
  }

  /**
   * Creates a new ChuckFactMsg RecordBuilder.
   * @return A new ChuckFactMsg RecordBuilder
   */
  public static org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder newBuilder() {
    return new org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder();
  }

  /**
   * Creates a new ChuckFactMsg RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ChuckFactMsg RecordBuilder
   */
  public static org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder newBuilder(org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder other) {
    if (other == null) {
      return new org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder();
    } else {
      return new org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder(other);
    }
  }

  /**
   * Creates a new ChuckFactMsg RecordBuilder by copying an existing ChuckFactMsg instance.
   * @param other The existing instance to copy.
   * @return A new ChuckFactMsg RecordBuilder
   */
  public static org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder newBuilder(org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg other) {
    if (other == null) {
      return new org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder();
    } else {
      return new org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder(other);
    }
  }

  /**
   * RecordBuilder for ChuckFactMsg instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ChuckFactMsg>
    implements org.apache.avro.data.RecordBuilder<ChuckFactMsg> {

    private java.lang.CharSequence id;
    private long timestamp;
    private java.lang.CharSequence fact;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.fact)) {
        this.fact = data().deepCopy(fields()[2].schema(), other.fact);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing ChuckFactMsg instance
     * @param other The existing instance to copy.
     */
    private Builder(org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.fact)) {
        this.fact = data().deepCopy(fields()[2].schema(), other.fact);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * @return The value.
      */
    public long getTimestamp() {
      return timestamp;
    }


    /**
      * Sets the value of the 'timestamp' field.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder setTimestamp(long value) {
      validate(fields()[1], value);
      this.timestamp = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder clearTimestamp() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'fact' field.
      * @return The value.
      */
    public java.lang.CharSequence getFact() {
      return fact;
    }


    /**
      * Sets the value of the 'fact' field.
      * @param value The value of 'fact'.
      * @return This builder.
      */
    public org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder setFact(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.fact = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'fact' field has been set.
      * @return True if the 'fact' field has been set, false otherwise.
      */
    public boolean hasFact() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'fact' field.
      * @return This builder.
      */
    public org.github.ogomezso.scs.infrastructure.model.chuck.ChuckFactMsg.Builder clearFact() {
      fact = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ChuckFactMsg build() {
      try {
        ChuckFactMsg record = new ChuckFactMsg();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.timestamp = fieldSetFlags()[1] ? this.timestamp : (java.lang.Long) defaultValue(fields()[1]);
        record.fact = fieldSetFlags()[2] ? this.fact : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ChuckFactMsg>
    WRITER$ = (org.apache.avro.io.DatumWriter<ChuckFactMsg>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ChuckFactMsg>
    READER$ = (org.apache.avro.io.DatumReader<ChuckFactMsg>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.id);

    out.writeLong(this.timestamp);

    out.writeString(this.fact);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);

      this.timestamp = in.readLong();

      this.fact = in.readString(this.fact instanceof Utf8 ? (Utf8)this.fact : null);

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
          break;

        case 1:
          this.timestamp = in.readLong();
          break;

        case 2:
          this.fact = in.readString(this.fact instanceof Utf8 ? (Utf8)this.fact : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










