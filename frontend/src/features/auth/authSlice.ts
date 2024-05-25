import { PayloadAction, createSlice } from '@reduxjs/toolkit';

export interface AuthState {
    username: string;
    roles: string[];
}

const initialState: AuthState = {
    username: '',
    roles: [],
};

const authSlice = createSlice({
    name: 'auth',
    initialState,
    reducers: {
        login(state, { payload }: PayloadAction<AuthState>) {
            state.username = payload.username;
            state.roles = payload.roles;
        },
        logout(state) {
            state.username = '';
            state.roles = [];
        },
    },
});

export const { login, logout } = authSlice.actions;
export default authSlice.reducer;
