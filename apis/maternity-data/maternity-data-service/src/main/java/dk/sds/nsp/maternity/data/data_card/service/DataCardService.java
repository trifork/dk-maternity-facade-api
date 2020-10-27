package dk.sds.nsp.maternity.data.data_card.service;

import dk.sds.nsp.maternity.data.data_card.model.CreateDataCardRequest;
import dk.sds.nsp.maternity.data.data_card.model.DataCardResponse;
import dk.sds.nsp.maternity.data.data_card.model.UpdateDataCardRequest;

import java.util.List;
import java.util.UUID;

public interface DataCardService {
    ServiceResponse<List<DataCardResponse>> get(final String patientIdentifier, final boolean breakTheGlass);
    ServiceResponse<DataCardResponse> get(final UUID id);
    ServiceResponse<DataCardResponse> create(final CreateDataCardRequest request);
    ServiceResponse<DataCardResponse> update(final UUID id, final UpdateDataCardRequest request);
    ServiceResponse<Void> delete(final UUID id);

    class ServiceResponse<T> {

        private final Status status;
        private final T entity;

        private enum Status { ok, partial, notFound, error }

        private ServiceResponse(final Status status, final T entity) {
            this.status = status;
            this.entity = entity;
        }

        public boolean isPartial() { return status == Status.partial; }
        public boolean isOk() { return status == Status.ok; }
        public boolean isError() { return status == Status.error; }
        public boolean isNotFound() { return status == Status.notFound; }
        public T getEntity() { return entity; }

        public static <T> ServiceResponse<T> ok(final T entity) { return new ServiceResponse<>(Status.ok, entity); }
        public static <T> ServiceResponse<T> ok() { return  new ServiceResponse<>(Status.ok, null); }
        public static <T> ServiceResponse<T> partial(final T entity) { return new ServiceResponse<>(Status.partial, entity); }
        public static <T> ServiceResponse<T> error() { return new ServiceResponse<>(Status.error, null); }
        public static <T> ServiceResponse<T> notFound() { return new ServiceResponse<>(Status.notFound, null); }

    }
}
