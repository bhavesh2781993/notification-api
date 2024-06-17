package in.digiborn.api.notification.mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import in.digiborn.api.notification.models.EmailNotification;
import in.digiborn.api.notification.models.requests.BroadcastEmailRequest;
import in.digiborn.api.notification.models.requests.PersonalisedEmailRequest;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    builder = @Builder(disableBuilder = true)
)
public interface EmailNotificationMapper {
    EmailNotification toEmailNotification(BroadcastEmailRequest broadcastEmailRequest);

    EmailNotification toEmailNotification(PersonalisedEmailRequest personalisedEmailRequest);

}
