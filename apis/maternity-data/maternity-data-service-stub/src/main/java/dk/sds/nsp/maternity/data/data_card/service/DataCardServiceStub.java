package dk.sds.nsp.maternity.data.data_card.service;

import dk.sds.nsp.maternity.data.data_card.model.CprIdentifiedPerson;
import dk.sds.nsp.maternity.data.data_card.model.CreateDataCardRequest;
import dk.sds.nsp.maternity.data.data_card.model.DataCardResponse;
import dk.sds.nsp.maternity.data.data_card.model.HealthCareOrganization;
import dk.sds.nsp.maternity.data.data_card.model.PersonName;
import dk.sds.nsp.maternity.data.data_card.model.UpdateDataCardRequest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static dk.sds.nsp.maternity.data.data_card.service.DataCardService.ServiceResponse.notFound;
import static dk.sds.nsp.maternity.data.data_card.service.DataCardService.ServiceResponse.ok;

public class DataCardServiceStub implements DataCardService {

    private static final UUID EPISODE_OF_CARE_IDENTIFIER = UUID.fromString("a312e032-8007-59cd-ba66-022cb8146b04");
    private final DataCardResponse dataCardResponse;

    public DataCardServiceStub() {
        dataCardResponse = new DataCardResponse()
                .modifiedTime(LocalDateTime.now())
                .author(new HealthCareOrganization()
                        .name("Jeppe Man"))
                .episodeOfCareIdentifier(EPISODE_OF_CARE_IDENTIFIER)
                .recordTarget(new CprIdentifiedPerson()
                        .identifier("6509810001")
                        .name(new PersonName()
                                .addFirstNamesItem("Ronnie")
                                .addMiddleNamesItem("Johnny")
                                .lastName("Lonnie")));

    }

    @Override
    public ServiceResponse<List<DataCardResponse>> get(String patientIdentifier, boolean breakTheGlass) {
        return ok(Collections.singletonList(dataCardResponse));
    }

    @Override
    public ServiceResponse<DataCardResponse> get(UUID id) {
        return EPISODE_OF_CARE_IDENTIFIER.equals(id) ? ok(dataCardResponse) : notFound();
    }

    @Override
    public ServiceResponse<DataCardResponse> create(CreateDataCardRequest request) {
        return ok(dataCardResponse);
    }

    @Override
    public ServiceResponse<DataCardResponse> update(UUID id, UpdateDataCardRequest request) {
        return EPISODE_OF_CARE_IDENTIFIER.equals(id) ? ok(dataCardResponse) : notFound();
    }

    @Override
    public ServiceResponse<Void> delete(UUID id) {
        return EPISODE_OF_CARE_IDENTIFIER.equals(id) ? ok() : notFound();
    }
}
