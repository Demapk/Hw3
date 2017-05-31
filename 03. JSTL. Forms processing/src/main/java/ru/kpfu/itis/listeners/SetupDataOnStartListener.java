package ru.kpfu.itis.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.model.Role;
import ru.kpfu.itis.model.enums.RoleEnumeration;
import ru.kpfu.itis.repository.RoleRepository;

@Component
public class SetupDataOnStartListener implements ApplicationListener<ContextRefreshedEvent> {
    private boolean isAlreadySetup = false;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (isAlreadySetup) {
            return;
        }
        roleRepository.save(new Role(RoleEnumeration.USER));
        roleRepository.save(new Role(RoleEnumeration.ADMIN));
        isAlreadySetup = true;
    }
}
