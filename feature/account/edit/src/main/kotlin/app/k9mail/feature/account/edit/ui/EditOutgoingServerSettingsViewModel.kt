package app.k9mail.feature.account.edit.ui

import androidx.lifecycle.viewModelScope
import app.k9mail.feature.account.common.domain.AccountDomainContract
import app.k9mail.feature.account.edit.domain.AccountEditDomainContract
import app.k9mail.feature.account.server.settings.ui.outgoing.OutgoingServerSettingsContract
import app.k9mail.feature.account.server.settings.ui.outgoing.OutgoingServerSettingsViewModel
import app.k9mail.feature.account.server.settings.ui.outgoing.toOutgoingConfigState
import kotlinx.coroutines.launch

class EditOutgoingServerSettingsViewModel(
    val accountUuid: String,
    private val accountStateLoader: AccountEditDomainContract.UseCase.LoadAccountState,
    validator: OutgoingServerSettingsContract.Validator,
    accountStateRepository: AccountDomainContract.AccountStateRepository,
    initialState: OutgoingServerSettingsContract.State = OutgoingServerSettingsContract.State(),
) : OutgoingServerSettingsViewModel(
    validator = validator,
    accountStateRepository = accountStateRepository,
    initialState = initialState,
) {
    override fun loadAccountState() {
        viewModelScope.launch {
            val state = accountStateLoader.execute(accountUuid)

            updateState {
                state.toOutgoingConfigState()
            }
        }
    }
}
