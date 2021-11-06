package core;

import core.useCase.Profiles;

public class LoginController {

    /* The collection of all profiles */
    private Profiles profiles;

    /**
     * Constructs a new LoginUseCase object
     * @param profiles: All the profiles that belong in the app
     */
    public LoginController(Profiles profiles)
    {
        this.profiles = profiles;
    }


}
