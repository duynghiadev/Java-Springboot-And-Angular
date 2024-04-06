import { ValidationError } from 'class-validator';

export class ValidationException extends Error {
  constructor(private readonly validationErrors: ValidationError[]) {
    super();
    Object.setPrototypeOf(this, ValidationException.prototype);
  }

  getValidationErrors() {
    return this.validationErrors;
  }
}
