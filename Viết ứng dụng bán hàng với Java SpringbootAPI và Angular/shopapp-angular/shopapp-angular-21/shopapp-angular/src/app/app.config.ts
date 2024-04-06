import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { withFetch } from '@angular/common/http';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { Provider } from '@angular/core';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './interceptors/token.interceptor';
import { importProvidersFrom } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { adminRoutes } from './components/admin/admin-routes';
import { RouterModule } from '@angular/router';

const tokenInterceptorProvider: Provider =
  { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true };


export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes), 
    //importProvidersFrom(RouterModule.forRoot(routes)),
    importProvidersFrom(RouterModule.forChild(adminRoutes)),    
    provideHttpClient(withFetch()),
    //provideHttpClient(),
    tokenInterceptorProvider,
    provideClientHydration(),
    importProvidersFrom(HttpClientModule),
  ]
};
